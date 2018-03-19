<?php

	include "koneksi.php";
	
	$nama = $_POST['nama_koleksi'];
	
	$query = mysql_query("SELECT koleksi.id_koleksi, koleksi.id_jenis, koleksi.nama_koleksi, jenis_koleksi.nama_jenis_koleksi, koleksi.asal_koleksi, koleksi.gambar
							FROM jenis_koleksi JOIN koleksi
							ON jenis_koleksi.id_jenis = koleksi.id_jenis
							WHERE nama_koleksi LIKE '%".$nama."%'");	

$num_rows = mysql_num_rows($query);

	if ($num_rows > 0){
		$json = '{"value":1, "results": [';

		while ($row = mysql_fetch_array($query)){
			$char ='"';

			$json .= '{
				"id_koleksi": "'.str_replace($char,'`',strip_tags($row['id_koleksi'])).'", 
				"gambar": "'.str_replace($char,'`',strip_tags($row['gambar'])).'"
				"nama_koleksi": "'.str_replace($char,'`',strip_tags($row['nama_koleksi'])).'"
				"nama_jenis_koleksi": "'.str_replace($char,'`',strip_tags($row['nama_jenis_koleksi'])).'"
				"asal_koleksi": "'.str_replace($char,'`',strip_tags($row['asal_koleksi'])).'"
			},';
		}

		$json = substr($json,0,strlen($json)-1);
		
		$json .= ']}';

	} else {
		$json = '{"value":0, "message": "Data tidak ditemukan."}';
	}

	echo $json;

?>