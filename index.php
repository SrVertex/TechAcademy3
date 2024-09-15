<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Verifica se o comando foi enviado
    if (isset($_POST['comando'])) {
        $comando = rawurlencode($_POST['comando']);

        // Faz a requisição ao servidor Java
        $conteudo = file_get_contents("http://localhost:4567/comando?comando={$comando}");

        // Decodifica a resposta JSON do servidor Java
        $arrayAssociativo = json_decode($conteudo, true);

        // Verifica se a resposta contém a mensagem e adiciona ao histórico da sessão
        if (isset($arrayAssociativo['mensagem'])) {
            $_SESSION['historico'] = isset($_SESSION['historico']) 
                ? array_merge($_SESSION['historico'], [$arrayAssociativo['mensagem']]) 
                : [$arrayAssociativo['mensagem']];
        }
    }
}

// Inclui o arquivo de visualização
include "index.phtml";
