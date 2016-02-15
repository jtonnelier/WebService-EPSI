<?php
session_start();
//echo "The id is " . $_SESSION["id"] . ".<br>";
//echo "The login is " . $_SESSION["login"] . ".<br>";
//echo "The password is " . $_SESSION["password"] . ".";
if(empty($_SESSION["id"])) {
    session_destroy();
    header('location:gifboard.php');
}
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Gifboard !!</title>
        <link rel="stylesheet" type="text/css" href="gifboard.css">
    </head>
    <body>
        <?php
        try {
            $bdd = new PDO('mysql:host=localhost;dbname=webservice;charset=utf8', 'wordpress', 'fTy4ADLtjevELLKa',
            array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
        }
        catch (Exception $e) {
            die('Erreur : ' . $e->getMessage());
        }

        $stmt = $bdd->prepare("SELECT lien FROM gif WHERE ID = :id AND ID_USER = :id_user");
        ?>
        <h1>Bienvenue dans votre Gifboard !</h1>
        <!-- 1st row verticaly centered text in the square columns -->

        <div class="square">
            <div class="content">
            <img id="gif6"/>
            </div>
        </div>

        <div class="square">
            <div class="content">
             <?php
                $count = 2;
                //$stmt = $bdd->prepare("SELECT lien FROM gif WHERE ID = 2");
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

        <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

                <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

        <!-- 2nd row verticaly centered images in square columns -->

                <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

                <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

                <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

                <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

        <!-- 3rd row responsive images in background with centered content -->

        <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

        <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

                <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>

                <div class="square">
            <div class="content">
             <?php
                $stmt->execute(array('id' => $count, 'id_user' => $_SESSION["id"]));
                $result = $stmt->fetchColumn();
                $count++;
                ?>
                <img id="result_img" src="<?php echo $result; ?>" />
            </div>
        </div>
        </body>
</html>