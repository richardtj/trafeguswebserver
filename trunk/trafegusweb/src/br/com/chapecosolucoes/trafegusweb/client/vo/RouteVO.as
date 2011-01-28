package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.enum.LocaisEnum;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
	
	import com.google.maps.LatLng;
	
	import mx.utils.ObjectUtil;

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
			this._vrotCodigo = obj.vrot_codigo.toString();
			this._vrotUsuarioAdicionou = obj.vrot_usuario_adicionou.toString();
			this._vrotUsuarioAlterou = obj.vrot_usuario_alterou.toString();
			this._vrotDataCadastro = obj.vrot_data_cadastro.toString();
			this.localOrigem = new LocalVO();
			this.localOrigem.vlocTparCodigo = LocaisEnum.ORIGEM.toString();
			this.localDestino = new LocalVO();
			this.localDestino.vlocTparCodigo = LocaisEnum.DESTINO.toString();
			
			this.localOrigem.codigo = obj.refe_codigo_origem.toString();
			this.localOrigem.descricao = obj.refe_descricao_origem.toString();
			this.localOrigem.gpsLatitudeString = obj.refe_latitude_origem.toString().replace(",", ".");
			this.localOrigem.gpsLongitudeString = obj.refe_longitude_origem.toString().replace(",", ".");
			gpsLatitude = Number(this.localOrigem.gpsLatitudeString);
			gpsLongitude = Number(this.localOrigem.gpsLongitudeString);
			this.localOrigem.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.localOrigem.vlocCodigo = obj.vloc_codigo_origem.toString();
			this.localOrigem.vlocDataCadastro = obj.vloc_data_cadastro_origem.toString();
			this.localOrigem.vlocRaio = obj.vloc_raio_origem.toString();
			this.localOrigem.vlocSequencia = obj.vloc_sequencia_origem.toString();
			this.localOrigem.vlocTparCodigo = obj.vloc_tpar_codigo_origem.toString();
			this.localOrigem.vlocUsuarioAdicionou = obj.vloc_usuario_adicionou_origem.toString();
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
			this.localDestino.vlocCodigo = obj.vloc_codigo_destino.toString();
			this.localDestino.vlocDataCadastro = obj.vloc_data_cadastro_destino.toString();
			this.localDestino.vlocRaio = obj.vloc_raio_destino.toString();
			this.localDestino.vlocSequencia = obj.vloc_sequencia_destino.toString();
			this.localDestino.vlocTparCodigo = obj.vloc_tpar_codigo_destino.toString();
			this.localDestino.vlocUsuarioAdicionou = obj.vloc_usuario_adicionou_destino.toString();
		}
		public function get vrotCodigo():String
		{
			return this._vrotCodigo==""?"nextval('s_vrot_viagem_rota')":this._vrotCodigo;
		}
		public function set vrotCodigo(vrot_codigo:String):void
		{
			this.vrotCodigo = vrot_codigo;
		}
		public function get vrotDataCadastro():String
		{
			return ("'"+(this._vrotDataCadastro==""?MyDateFormatter.getInstance().parse(new Date()):this._vrotDataCadastro)+"'");
		}
		public function get vrotUsuarioAdicionou():String
		{
			return "'"+(this._vrotUsuarioAdicionou==""?ObjectUtil.toString(MainModel.getInstance().codUsuario):this._vrotUsuarioAdicionou)+"'";
		}
		public function get vrotUsuarioAlterou():String
		{
			return "'"+ObjectUtil.toString(MainModel.getInstance().codUsuario)+"'";
		}
		public var codigo:String;
		private var _vrotCodigo:String;
		public var descricao:String;
		public var distancia:String;
		public var coordenada:String;
		public var dataCadastro:String;
		public var coordenadasPipe:String;
		public var localOrigem:LocalVO;
		public var localDestino:LocalVO;
		private var _vrotUsuarioAdicionou:String = "";
		private var _vrotUsuarioAlterou:String = "";
		private var _vrotDataCadastro:String = "";
	}
}