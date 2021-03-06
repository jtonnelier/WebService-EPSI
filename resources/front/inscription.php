<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
    </head>
    <body>

        <h1>Inscrivez-vous !</h1>
        <h2>Entrez les données demandées :</h2>
        <form name="inscription" method="post" >
            login : <input type="text" name="login" required/> <br/>
            password : <input type="password" name="password" required/> <br/>
            mail : <input type="mail" name="mail" required/><br/>
            <input type="submit" name="valider" value="OK"/>
        </form>

        <?php
        if (isset ($_POST['valider'])){
            $login=$_POST['login'];
            $password=$_POST['password'];
            $mail=$_POST['mail'];

            $encodePassword= base64_encode($password);

            try {
                $bdd = new PDO('mysql:host=localhost;dbname=webservice;charset=utf8', 'wordpress', 'fTy4ADLtjevELLKa');
            } catch (Exception $e) {
                die('Erreur : ' . $e->getMessage());
            }

            $req = $bdd->prepare('INSERT INTO utilisateur (login, password, mail, role) VALUES(?, ?, ?, ?)');
            $req->execute(array($_POST['login'], $encodePassword, $_POST['mail'], 1));

            header('location:connexion.php');
            exit;
            };
        ?>

        <br style="clear:both;"/>
        <form name="return" method="post">
        <input type="submit" name="return" value="J'ai déjà un compte !"/>
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