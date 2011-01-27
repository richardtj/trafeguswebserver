package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;

	[Bindable]
	public class LocalVO
	{
		public function LocalVO()
		{
		}
		public function setLocalVO(obj:Object):void
		{
			this.codigo = obj.refe_codigo.toString();
			this.descricao = obj.refe_descricao.toString();
			gpsLatitudeString = obj.refe_latitude.toString().replace(",", ".");
			gpsLongitudeString = obj.refe_longitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.codigoGrupo = obj.cref_codigo.toString();
			this.descricaoGrupo = obj.cref_descricao.toString();
		}
		public function set vloc_codigo(vloc_codigo:String):void
		{
			this.codigo = vloc_codigo;
		}
		public function get vloc_codigo():String
		{
			return this.codigo==""?"nextval('s_vloc_viagem_local')":this.codigo;
		}
		public var codigo:String;
		public var descricao:String;
		public var latLong:LatLng;
		public var codigoGrupo:String;
		public var descricaoGrupo:String;
		public var gpsLatitudeString:String;
		public var gpsLongitudeString:String;
	}
}