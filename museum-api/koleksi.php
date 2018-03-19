<?php

	include "koneksi.php";
	
	$id_kategori = $_GET['id_kategori'];
	
	$query = mysql_query("SELECT koleksi.id_koleksi, koleksi.id_jenis, koleksi.nama_koleksi, jenis_koleksi.nama_jenis_koleksi, koleksi.asal_koleksi, koleksi.gambar, koleksi.deskripsi
							FROM jenis_koleksi JOIN koleksi
							ON jenis_koleksi.id_jenis = koleksi.id_jenis
							WHERE id_kategori = '$id_kategori'");	

	$response = array();
	
	while($hasil = mysql_fetch_assoc($query))	{
			array_push($response, $hasil);
	}
	
	$response = array_map(function($r) {
		$r['gambar'] = utf8_encode($r['gambar']);
		$r['nama_koleksi'] = utf8_encode($r['nama_koleksi']);
		$r['deskripsi'] = utf8_encode($r['deskripsi']);
		$r['asal_koleksi'] = utf8_encode($r['asal_koleksi']);
		return $r;
	}, $response);

	header('Content-Type: application/json; charset=utf-8');
	
	echo json_encode(array('koleksi' => $response));

?>