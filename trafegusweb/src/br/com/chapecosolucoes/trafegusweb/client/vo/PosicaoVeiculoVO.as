package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;

	public class PosicaoVeiculoVO
	{
		public function PosicaoVeiculoVO(obj:Object=null)
		{
			var gpsLatitudeString:String = obj.gpslatitude.toString().replace(",", ".");
			var gpsLongitudeString:String = obj.gpslongitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			
			this.vehiclePlate = obj.vehicleplate.toString();
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.gpsDescSis = obj.gpsdescsis;
			this.ignition = int(obj.ignition);
			this.versaoTecnologia = obj.versaotecnologia.toString();
			this.numeroTerminal = obj.numeroterminal.toString();
			this.tipoVeiculo = obj.tipoveiculo.toString();
			this.statusViagem = obj.statusviagem.toString();
			this.statusAtraso = obj.statusatraso.toString();
			this.motoristaPrincipal = obj.motoristaprincipal.toString();
		}
		public var vehiclePlate:String;
		public var latLong:LatLng;
		public var gpsDescSis:String;
		public var ignition:int;
		public var versaoTecnologia:String;
		public var numeroTerminal:String;
		public var tipoVeiculo:String;
		public var statusViagem:String;
		public var statusAtraso:String;
		public var motoristaPrincipal:String;
	}
}