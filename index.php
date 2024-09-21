<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['comando'])) {
    $comando = $_POST['comando'];

    // Enviar requisição ao servidor Java
    $url = 'http://localhost:4567/comando'; // URL do servidor Java
    $data = http_build_query(array('comando' => $comando));

    $options = array(
        'http' => array(
            'header'  => "Content-type: application/x-www-form-urlencoded\r\n",
            'method'  => 'POST',
            'content' => $data,
        ),
    );
    $context  = stream_context_create($options);
    $result = file_get_contents($url, false, $context);

    // Exibir resposta do servidor Java
    if ($result === FALSE) {
        $result = 'Erro ao processar comando.';
    }

    // Adicionar resposta ao histórico
    if (!isset($_SESSION['historico'])) {
        $_SESSION['historico'] = array();
    }
    $_SESSION['historico'][] = $result;
}

// reponciviade do front-end

session_start();

// Função para enviar requisição HTTP POST
function sendPostRequest($url, $data) {
    $options = array(
        'http' => array(
            'header'  => "Content-type: application/x-www-form-urlencoded\r\n",
            'method'  => 'POST',
            'content' => http_build_query($data),
        ),
    );
    $context  = stream_context_create($options);
    return file_get_contents($url, false, $context);
}

// Processar comando
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['comando'])) {
    $comando = $_POST['comando'];
    $url = 'http://localhost:4567/comando'; // URL do servidor Java
    $result = sendPostRequest($url, array('comando' => $comando));

    // Adicionar resposta ao histórico
    if (!isset($_SESSION['historico'])) {
        $_SESSION['historico'] = array();
    }
    $_SESSION['historico'][] = $result;
}

// comando para limpar o historico
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['clear'])) {
    // Enviar requisição para resetar o jogo
    $url = 'http://localhost:4567/reset';
    $result = sendPostRequest($url, array());

    // Limpar histórico
    $_SESSION['historico'] = array();
    $_SESSION['historico'][] = $result;
}

// Salvar o progresso
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['save'])) {
    // Enviar requisição para salvar o progresso
    $url = 'http://localhost:4567/save'; // URL do servidor Java
    $result = sendPostRequest($url, array());

    // Adicionar resposta ao histórico
    if (!isset($_SESSION['historico'])) {
        $_SESSION['historico'] = array();
    }
    $_SESSION['historico'][] = $result;
}












//session_start();

if ($_GET['comando'] && $_GET['save']) {
    $comando = rawurlencode($_GET['comando']);
    $save = rawurlencode($_GET['save']);
    $conteudo = file_get_contents("http://localhost:4567/{$comando}/{$save}");
} else if(isset($_GET['comando'])) {
    $comando = rawurlencode($_GET['comando']);
    $conteudo = file_get_contents("http://localhost:4567/{$comando}");
} else {
    $conteudo = file_get_contents("http://localhost:4567");
}


$arrayAssociativo = json_decode($conteudo);








// session_start();

// if ($_GET['comando'] && $_GET['save']) {
//     $comando = rawurlencode($_GET['comando']);
//     $save = rawurlencode($_GET['save']);
//     echo "Rota 1";
//     $conteudo = file_get_contents("http://localhost:4567/{$comando}/{$save}");
// } else if(isset($_GET['comando'])) {
//     $comando = rawurlencode($_GET['comando']);
//     echo $comando;
//     $conteudo = file_get_contents("http://localhost:4567/{$comando}");
// } else {
//     echo "Rota 3";
//     $conteudo = file_get_contents("http://localhost:4567");
// }


// $arrayAssociativo = json_decode($conteudo);

// print_r($arrayAssociativo);
// //$_SESSION['historico'] = isset($_SESSION['historico']) ? array_merge($_SESSION['historico'], $arrayAssociativo->messages) : [];

// $messages = $arrayAssociativo->mensagem;





include "index.phtml";
