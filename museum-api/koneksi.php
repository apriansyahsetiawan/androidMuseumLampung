<?php
	
	$server		= "localhost"; // sesuaikan alamat server anda
	$username	= "root"; // sesuaikan user web server anda
	$password	= ""; // sesuaikan password web server anda
	$database	= "museum"; // sesuaikan database web server anda
	
	mysql_connect($server, $username, $password) or die ("Tidak Ada Koneksi!");
	mysql_select_db($database) or die ("Database Tidak Ditemukan!");
?>