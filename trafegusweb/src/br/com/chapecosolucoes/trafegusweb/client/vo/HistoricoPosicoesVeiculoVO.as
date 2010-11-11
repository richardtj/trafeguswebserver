package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;
	
	import mx.collections.ArrayCollection;

	public class HistoricoPosicoesVeiculoVO
	{
		public function HistoricoPosicoesVeiculoVO(obj:Object)
		{
			var gpsLatitudeString:String = obj.rpos_latitude.toString().replace(",", ".");
			var gpsLongitudeString:String = obj.rpos_longitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.gpsDescSis = obj.rpos_descricao_sistema;
			this.dataEHora = obj.rpos_data_computador_bordo;
		}
		public var latLong:LatLng;
		public var gpsDescSis:String;
		public var dataEHora:String;
	}
}