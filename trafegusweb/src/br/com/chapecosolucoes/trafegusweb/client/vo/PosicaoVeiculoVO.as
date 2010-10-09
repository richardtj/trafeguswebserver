package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;

	public class PosicaoVeiculoVO
	{
		public function PosicaoVeiculoVO(obj:Object)
		{
			var gpsLatitudeString:String = obj.GPSLatitude.toString().replace(",", ".");
			var gpsLongitudeString:String = obj.GPSLongitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			
			this.vehiclePlate = obj.VehiclePlate.toString();
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.gpsDescSis = obj.GPSDescSis;
			this.ignition = int(obj.Ignition);
		}
		public var vehiclePlate:String;
		public var latLong:LatLng;
		public var gpsDescSis:String;
		public var ignition:int;
	}
}