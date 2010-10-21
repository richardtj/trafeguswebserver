package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;
	
	import mx.collections.ArrayCollection;

	public class HistoricoPosicoesVeiculoVO
	{
		public function HistoricoPosicoesVeiculoVO(obj:Object)
		{
			var gpsLatitudeString:String = obj.gpslatitude.toString().replace(",", ".");
			var gpsLongitudeString:String = obj.gpslongitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.gpsDescSis = obj.gpsdescsis;
			this.dataEHora = obj.dataehora;
		}
		public var latLong:LatLng;
		public var gpsDescSis:String;
		public var dataEHora:String;
	}
}