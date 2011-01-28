package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
	
	import com.google.maps.LatLng;
	
	import mx.utils.ObjectUtil;

	[Bindable]
	public class LocalVO
	{
		public function LocalVO()
		{
		}
		public function setLocalVO(obj:Object):void
		{
			this.codigo = obj.refe_codigo.toString();
			this._vlocCodigo = obj.vloc_codigo.toString();
			this.vlocSequencia = obj.vloc_sequencia.toString();
			this.vlocTparCodigo = obj.vloc_tpar_codigo.toString();
			this.vlocRaio = obj.vloc_raio.toString();
			this._vlocDataCadastro = obj.vloc_data_cadastro.toString();
			this._vlocUsuarioAdicionou = obj.vloc_usuario_adicionou.toString();
			//this.vlocUsuarioAlterou = obj.vloc_usuario_alterou.toString();
			this.descricao = obj.refe_descricao.toString();
			gpsLatitudeString = obj.refe_latitude.toString().replace(",", ".");
			gpsLongitudeString = obj.refe_longitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.codigoGrupo = obj.cref_codigo.toString();
			this.descricaoGrupo = obj.cref_descricao.toString();
		}
		public function set vlocCodigo(vlocCodigo:String):void
		{
			this.codigo = vlocCodigo;
		}
		public function get vlocCodigo():String
		{
			return this.codigo==""?"nextval('s_vloc_viagem_local')":this.codigo;
		}
		public function set vlocDataCadastro(vlocDataCadastro:String):void
		{
			this._vlocDataCadastro = vlocDataCadastro;
		}
		public function get vlocDataCadastro():String
		{
			return this._vlocDataCadastro==""?MyDateFormatter.getInstance().parseTime(new Date()):this._vlocDataCadastro;
		}
		public function set vlocUsuarioAdicionou(vlocUsuarioAdicionou:String):void
	    {
			this._vlocUsuarioAdicionou = vlocUsuarioAdicionou;									 
    	}
		public function get vlocUsuarioAdicionou():String
		{
			return this._vlocUsuarioAdicionou==""?ObjectUtil.toString(MainModel.getInstance().codUsuario):this._vlocUsuarioAdicionou;
		}
		public function get vlocUsuarioAlterou():String
		{
			return ObjectUtil.toString(MainModel.getInstance().codUsuario);
		}
		public var codigo:String;
		public var descricao:String;
		public var latLong:LatLng;
		public var codigoGrupo:String;
		public var descricaoGrupo:String;
		public var gpsLatitudeString:String;
		public var gpsLongitudeString:String;
		public var vlocSequencia:String;
		public var vlocTparCodigo:String;
		public var vlocRaio:String = "";
		private var _vlocCodigo:String;
		private var _vlocDataCadastro:String = "";
		private var _vlocUsuarioAdicionou:String = "";
		private var _vlocUsuarioAlterou:String = "";
	}
}