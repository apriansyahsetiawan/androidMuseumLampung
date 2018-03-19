<?php

	include "koneksi.php";
	
	//$id_jenis = $_GET['id_jenis'];
	$id_koleksi = $_GET['id_koleksi'];
	//id_kategori = '$id_kategori' OR 
	
	$query = mysql_query("SELECT koleksi.id_koleksi, koleksi.id_jenis, koleksi.nama_koleksi, jenis_koleksi.nama_jenis_koleksi, koleksi.asal_koleksi, koleksi.gambar, koleksi.deskripsi
							FROM koleksi JOIN jenis_koleksi
							ON koleksi.id_jenis = jenis_koleksi.id_jenis
							WHERE id_koleksi = '$id_koleksi'");	

	$response = array();
	
	while($data = mysql_fetch_assoc($query))
	{
			$response[] = $data;
	}

	$hasil = json_encode($response);

	echo "{\"detail_koleksi\":" .$hasil ."}";


?>