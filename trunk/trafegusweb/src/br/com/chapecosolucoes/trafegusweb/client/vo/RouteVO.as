package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;

	[Bindable]
	public class RouteVO
	{
		public function RouteVO()
		{
			
		}
		public function setRouteVO(obj:Object):void
		{
			var gpsLatitude:Number;
			var gpsLongitude:Number;
			
			this.codigo = obj.rota_codigo.toString();
			this.descricao = obj.rota_descricao.toString();
			this.distancia = obj.rota_distancia.toString();
			this.coordenada = obj.rota_coordenada.toString();
			this.dataCadastro = obj.rota_data_cadastro.toString();
			this.coordenadasPipe = obj.rota_coordenadaspipe.toString();
			this.localOrigem = new LocalVO();
			this.localDestino = new LocalVO();
			
			this.localOrigem.codigo = obj.refe_codigo_origem.toString();
			this.localOrigem.descricao = obj.refe_descricao_origem.toString();
			this.localOrigem.gpsLatitudeString = obj.refe_latitude_origem.toString().replace(",", ".");
			this.localOrigem.gpsLongitudeString = obj.refe_longitude_origem.toString().replace(",", ".");
			gpsLatitude = Number(this.localOrigem.gpsLatitudeString);
			gpsLongitude = Number(this.localOrigem.gpsLongitudeString);
			this.localOrigem.latLong = new LatLng(gpsLatitude, gpsLongitude);
			//this.localOrigem.codigoGrupo = obj.cref_codigo_origem.toString();
			//this.localOrigem.descricaoGrupo = obj.cref_descricao_origem.toString();
			
			this.localDestino.codigo = obj.refe_codigo_destino.toString();
			this.localDestino.descricao = obj.refe_descricao_destino.toString();
			this.localDestino.gpsLatitudeString = obj.refe_latitude_destino.toString().replace(",", ".");
			this.localDestino.gpsLongitudeString = obj.refe_longitude_destino.toString().replace(",", ".");
			gpsLatitude = Number(this.localDestino.gpsLatitudeString);
			gpsLongitude = Number(this.localDestino.gpsLongitudeString);
			this.localDestino.latLong = new LatLng(gpsLatitude, gpsLongitude);
			//this.localDestino.codigoGrupo = obj.cref_codigo_destino.toString();
			//this.localDestino.descricaoGrupo = obj.cref_descricao_destino.toString();
		}
		public function get vrot_codigo():String
		{
			return this.codigo==""?"nextval('s_vrot_viagem_rota')":this.codigo;
		}
		public function set vrot_codigo(vrot_codigo:String):void
		{
			this.codigo = vrot_codigo;
		}
		public var codigo:String;
		public var descricao:String;
		public var distancia:String;
		public var coordenada:String;
		public var dataCadastro:String;
		public var coordenadasPipe:String;
		public var localOrigem:LocalVO;
		public var localDestino:LocalVO;
	}
}