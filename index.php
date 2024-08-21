<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">

    <title>jogo em java</title>

    <link rel="shortcut icon" href="imagens/logo2.jpg">

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet" href="https://unpkg.com/aos@2.3.1/dist/aos.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

</head>

    <body>


    <!-- Titulo do jogo -->
    <header>

        <div class="logo">
            <img src="imagens/logo1.jpg" alt="">
            <h2>Java</h2>
        </div>


        <!-- buttons -->
        <nav>
            <form action="" method="post">
                <button id="reset" type="submit" name="reset" style="margin: 0 10px 0 0 ;">Reset</button>
                <button type="" href="">Save</button>
            </form>
        </nav>

    </header>

    <!-- conteudo prinscipal -->
    <main>

        <section id="main">
            <!-- conteiner de historia -->
            <div class="historia">
                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolores debitis excepturi asperiores et,
                    maiores consequatur ex voluptate, sed ratione consequuntur praesentium aut quisquam sequi saepe
                    culpa, officia odit? Repellendus, nihil!
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolores debitis excepturi asperiores et,
                </p>
            </div>

            <!--  conteudo principal-->
            <div class="form-bg">
                <!-- imagens game -->

                <div class="form-center">

                    <span>
                        <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolores debitis excepturi
                            asperiores et,
                            maiores consequatur ex voluptate, sed ratione consequuntur praesentium aut quisquam sequi
                            saepe
                            culpa, officia odit? Repellendus, nihil!
                            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolores debitis excepturi
                            asperiores et,
                        </p>
                        </span>
                        <br>
                  

                </div>
            </div>


            <!-- barra de pesquisa  -->
            <div class="form-psq">

                <form action="">
                    <!-- input de pesquisa -->
                    <input type="search" placeholder="Digite os codigos" required>

                    <!-- botão de pesquisa -->
                    <a href="" type="submit" style="color: white;">

                        <i class="bi bi-arrow-up-square-fill"></i>

                    </a>

                </form>
            </div>

        </section>




</body>

<!-- COMANDO EM JAVSSCRIPT -->
<!-- COMANDO EM JAVSSCRIPT -->
<!-- COMANDO EM JAVSSCRIPT -->

<script src="js/bootstrap.bundle.min.js"></script>

<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

<script>
    AOS.init();
</script>
<script>
    const btn = document.querySelector('#reset')

    btn.addEventListener('click', () => {
        location.reload()
    })
</script>

</html>



<!--  BACK-END EM PHP  -->
<!--  BACK-END EM PHP  -->
<!--  BACK-END EM PHP  -->


<?php
// if (isset($_POST['reset'])) {
//     // Handle any reset logic if needed
//     header("Refresh:0"); // Refresh the page
//     exit;
// }

// $showAlert = true;

// if ($showAlert) {
//     echo "<script>
//             alert('Todos os seu Itens e Progresso no jogo seram resetados!');
//                 </script>";
// }


?>