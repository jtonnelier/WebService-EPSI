<?php
session_start();
//echo "The id is " . $_SESSION["id"] . ".<br>";
//echo "The login is " . $_SESSION["login"] . ".<br>";
//echo "The password is " . $_SESSION["password"] . ".";
if(empty($_SESSION["id"])) {
    session_destroy();
    header('location:gifboard.php');
}

try {
    $bdd = new PDO('mysql:host=localhost;dbname=webservice;charset=utf8', 'wordpress', 'fTy4ADLtjevELLKa',
    array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
} catch (Exception $e) {
    die('Erreur : ' . $e->getMessage());
}

$pageId = 0;
$MAX_PER_PAGE = 3;

try { if (isset($_GET['page'])) {
    $pageId = intVal($_GET['page']); }
} catch (Exception $e) { }

$sqlString = "SELECT id, lien FROM gif WHERE ID_USER = :id_user LIMIT ".($MAX_PER_PAGE * $pageId).", ".$MAX_PER_PAGE;
//echo $sqlString;
$stmt = $bdd->prepare($sqlString);
$stmt->execute(array('id_user' => $_SESSION["id"]));

/* compte le nombre de pages */
$count = $bdd->query("SELECT COUNT(*) FROM gif WHERE ID_USER = ".$_SESSION["id"])->fetchColumn();
//echo '<br/>count: '.$count;
$numberOfPages = ($count / $MAX_PER_PAGE); // si c'est pas un nombre entier faire un arrondi sup. sinon faire +1
$count = $bdd->query("SELECT COUNT(*) FROM gif WHERE ID_USER = ".$_SESSION["id"])->fetchColumn();
//echo '<br/>count: '.$count;
$numberOfPages = ($count / $MAX_PER_PAGE);
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Gifboard !!</title>
        <link rel="stylesheet" type="text/css" href="gifboard.css">
        <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    </head>
    <body>
        <h1>Bienvenue dans votre Gifboard !</h1>
        <?php
            while ($result = $stmt->fetch()) {
                echo '<div class="square">';
                echo '<div class="content">';
                echo '<img class="result_img" src="'.$result['lien'].'" />';
                echo '</div>';
                echo '</div>';
            }
        ?>

        <br style="clear:both;"/>
        <h2>Insérez votre gif !</h2>
        <form name="upload" method="post">
        Hashtag : <input type="text" name="hashtag" required/> <br />
        Lien : <input type="text" name="link" required/> <br/>
        <input type="submit" name="upload" value="Upload"/>
        </form>
        <?php
        if (isset ($_POST['upload'])){
            $hashtag=$_POST['hashtag'];
            $link=$_POST['link'];

            $req = $bdd->prepare('INSERT INTO gif (id_user, label, lien, site) VALUES(?, ?, ?, ?)');
            $req->execute(array($_SESSION["id"], $_POST['hashtag'], $_POST['link'], 1));

            header('location:gifboard.php');
            exit;
        };
        ?>

        <br/>
            <h2>Cherchez un gif sur giphy !</h2>
            Recherche: <input type="text" id="rechercheInput"/>
            <button id="rechercheButton"></button>
            <div id="rechercheResltat"></div>
            <script>
            $('#rechercheButton').click(function() {
            // tu peux recuperer $('#rechercheInput').val() pour ta recherche
            $.get( "apiTest.php?tag=toto", function( data ) {
            console.log(data);
            data['gifs'].forEach(function(element) {
            console.log(element);
            $('#rechercheResltat').append($( "<img src='"+ element.lien +"'/>"));
            });
            });
            });
            </script>

        <br style="clear:both;"/>
        <div id="pager">
            <?php
            //echo $numberOfPages -1;
            //var_dump(range(0, $numberOfPages -1));
            if ($numberOfPages-1 <= 0) {

            } else foreach (range(0, $numberOfPages) as $i) { /* -1 car commence a la page 0 */
                if ($pageId == $i) {
                    echo '<span>'.$i.'</span>';
                } else {
                    echo '<span><a href="?page='.$i.'">'.$i.'</a></span>';
                }
            }
            ?>
        </div>
    </body>

</html>