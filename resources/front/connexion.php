<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
    </head>
    <body>
        <h1>Connectez-vous !</h1>
        <h2>Entrez les données demandées :</h2>
        <form name="connexion" method="post">
            login : <input type="text" name="login" required/> <br/>
            password : <input type="password" name="password" required/> <br/>
            <input type="submit" name="log" value="Se connecter"/>
        </form>

        <?php
        session_start();
        if (isset ($_POST['log'])){
            try {
                $bdd = new PDO('mysql:host=localhost;dbname=webservice;charset=utf8', 'wordpress', 'fTy4ADLtjevELLKa',
                array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
            } catch (Exception $e) {
                die('Erreur : ' . $e->getMessage());
            }

            $password = $_POST['password'];
            $encodePassword= base64_encode($password);
            echo $encodePassword;

            $req = $bdd->prepare('SELECT id, login, password FROM utilisateur WHERE login = :login AND password = :password');
            $req->execute(array('login' => $_POST['login'], 'password' => $encodePassword));
            $row = $req->fetch();

            if ($req->rowCount() == 1) {
                $_SESSION["id"] = $row['id'];
                $_SESSION["login"] = $_POST['login'];
                $_SESSION["password"] = $encodePassword;
                header('location:gifboard.php');
            } else {
                echo 'Login/Password incorrect !';
            }
        }
        ?>

        <br style="clear:both;"/>
        <form name="return" method="post">
        <input type="submit" name="return" value="S'inscrire"/>
        </form>
        <?php
        if (isset ($_POST['return'])){
            session_destroy();
            header('location:inscription.php');
            exit;
        };
        ?>
    </body>
</html>