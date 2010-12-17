package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	public class ReferenciaVO
	{
		public function ReferenciaVO()
		{
		}
		public function setReferenciaVO(obj:Object):void{
			this.codigo = obj.cref_codigo.toString();
			this.descricao = obj.cref_descricao.toString();
			this.refeDescricao = obj.refe_descricao.toString();
			
			var gpsLatitudeString:String = obj.refe_latitude.toString().replace(",", ".");
			var gpsLongitudeString:String = obj.refe_longitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
		}
		public var codigo:String;
		public var descricao:String;
		public var refeDescricao:String;
		public var latLong:LatLng;
	}
}