<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Egreso</title>
    <link rel="stylesheet" href="css/styleMovimientos.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>

</head>

<body>
    <!-- nav -->
    <header class="header_pagina_principal">
        <button class="boton boton2 usuario_shortcut">
            <img src="https://picsum.photos/30" alt="imagen de usuario">
            <p>Usuario</p>
        </button>
        <div>
            <a href="DashboardController?ruta=ver">
                <iconify-icon class="icono" icon="carbon:view-filled" width="18"></iconify-icon>
                <span>Dashboard</span>
            </a>
            <a href="ConfiguracionController?ruta=configuracion">
                <iconify-icon class="icono" icon="carbon:view-filled" width="18"></iconify-icon>
                <span>ConfiguraciÃ³n</span>
            </a>
        </div>
    </header>
    <main>
        <div class="contenedor-configuracion">
            <ul>
                <li><a href="">Cuentas</a></li>
                <li><a href="">Categorias</a></li>
            </ul>
        </div>
    </main>

</body>

</html>