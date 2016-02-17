<?php
session_start();
//echo "The id is " . $_SESSION["id"] . ".<br>";
//echo "The login is " . $_SESSION["login"] . ".<br>";
//echo "The password is " . $_SESSION["password"] . ".";
if(empty($_SESSION["id"])) {
    session_destroy();
    header('location:connexion.php');
}
if(empty($_SESSION["login"])) {
    session_destroy();
    header('location:connexion.php');
}
if(empty($_SESSION["password"])) {
    session_destroy();
    header('location:connexion.php');
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
        <div id="pager">
            <?php
            //echo $numberOfPages -1;
            //var_dump(range(0, $numberOfPages -1));
            if ($numberOfPages-1 <= 0) {

            } else
            echo 'Pages : ';
            foreach (range(0, $numberOfPages) as $i) { /* -1 car commence a la page 0 */
                if ($pageId == $i) {
                    echo '<span>'.$i.' </span>';
                } else {
                    echo '<span><a href="?page='.$i.' ">'.$i.'</a></span>';
                }
            }
            ?>
        </div>

        <br style="clear:both;"/>
        <h2>Insérez votre gif !</h2>
        <form name="upload" method="post">
        Hashtag : <input type="text" name="hashtag" required/> <br />
        Lien : <input type="text" name="link" required/> <br/>
        <input type="submit" name="upload" value="upload"/>
        </form>
        <?php
        if (isset ($_POST['upload'])){
            $req = $bdd->prepare('INSERT INTO gif (id_user, label, lien, site) VALUES(?, ?, ?, ?)');
            $req->execute(array($_SESSION["id"], $_POST['hashtag'], $_POST['link'], 1));

            header('location:gifboard.php');
            exit;
        };
        ?>

        <br/>
        <h2>Cherchez un gif !</h2>
        Recherche: <input type="text" id="rechercheInput"/>
        <button id="rechercheButton">Rechercher</button>
        <div id="rechercheResltat"></div>
        <script>
        var GIF_SEARCH_RESULTS = [];
        var SEARCH_INPUT;
        function showGifSearch() {
            /* on vide le tableau de resultats */
            $('#rechercheResltat').html("");

            /* on parcours la global pour afficher les gif  */
            $.each(GIF_SEARCH_RESULTS, function(key, gif) {
                /* l'objet gif contient plein de trucs, je choisit d'afficher l'image fixed_with_small */
                /* lorsqu'on clic sur une image je fais un console.log => on peut voir ce que contient l'objet */
                $('#rechercheResltat').append($( "<img onclick='onGifClick(" + key + ")' class='rechercheResult' id='gif_" + gif.id + "' src='"+ gif.images.fixed_width_small.url +"'/>"));
            });
        }

        function onGifClick(idx) {
            console.log(GIF_SEARCH_RESULTS[idx]);
            /* on pourrait imaginer faire un

            $.post('gifboard', data = {'upload': 'ajax', 'hashtag': SEARCH_INPUT, 'link': GIF_SEARCH_RESULTS[idx].images.fixed_width_small.url});
            => ici pas de verification du retour mais c'est possible
            */
        }

        $('#rechercheButton').click(function() {
            // tu peux recuperer $('#rechercheInput').val() pour ta recherche
            var searchTag = $('#rechercheInput').val();
            $.get( "http://api.giphy.com/v1/gifs/search?api_key=dc6zaTOxFJmzC&q=" + searchTag, function( data ) {
                /* on sauvegarde dans la global */
                GIF_SEARCH_RESULTS = data.data;
                SEARCH_INPUT = searchTag;
                /* on affiche les resultats */
                showGifSearch();
            });
        });
</script>

        <br style="clear:both;"/>
        <form name="return" method="post">
        <input type="submit" name="return" value="Se déconnecter"/>
        </form>
        <?php
        if (isset ($_POST['return'])){
            session_destroy();
            header('location:connexion.php');
            exit;
        };
        ?>

</body>
</html>