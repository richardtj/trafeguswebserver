package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	
	import mx.collections.SortField;
	import mx.utils.ObjectUtil;

	[Bindable]
	public class VeiculoVO
	{
		public function VeiculoVO()
		{
		}
		public function setVeiculoVO(obj:Object):void
		{
			this.cod = obj.veic_oras_codigo.toString();
			this._vveiCodigo = obj.vvei_codigo.toString();
			this._vveiEvcaCodigo = obj.vvei_evca_codigo.toString();
			this._vveiMotoPfisPessOrasCodigo = obj.vvei_moto_pfis_pess_oras_codigo.toString();
			this.vehiclePlate = obj.veic_placa.toString();
			this.desc = obj.tvei_descricao.toString();
			this.cor = obj.veic_cor.toString();
			this.seq = obj.vvei_sequencia.toString();
			this._vveiUsuarioAdicionou = obj.vvei_usuario_adicionou.toString();
			this._vveiUsuarioAlterou = obj.vvei_usuario_alterou.toString();
			this.precedencia = obj.vvei_precedencia.toString();
		}
		public function set vveiSequencia(vveiSequencia:String):void
		{
			this.seq = vveiSequencia;
		}
		public function get vveiSequencia():String
		{
			return this.seq==""?"NULL":this.seq;
		}
		public function get vveiCodigo():String
		{
			return this._vveiCodigo==""?"nextval('s_vvei_viagem_veiculo')":this._vveiCodigo;
		}
		public function get vveiEvcaCodigo():String
		{
			return this._vveiEvcaCodigo==""?"1":this._vveiEvcaCodigo;
		}
		public function get vveiUsuarioAdicionou():String
		{
			return this._vveiUsuarioAdicionou==""?ObjectUtil.toString(MainModel.getInstance().codUsuario):this._vveiUsuarioAdicionou;
		}
		public function get vveiUsuarioAlterou():String
		{
			return ObjectUtil.toString(MainModel.getInstance().codUsuario);
		}
		public function set vveiMotoPfisPessOrasCodigo(vveiMotoPfisPessOrasCodigo:String):void
		{
			this._vveiMotoPfisPessOrasCodigo = vveiMotoPfisPessOrasCodigo;
		}
		public function get vveiMotoPfisPessOrasCodigo():String
		{
			return this._vveiMotoPfisPessOrasCodigo==""?"NULL":this._vveiMotoPfisPessOrasCodigo;
		}
		public function set precedencia(precedencia:String):void
		{
			this._precedencia = precedencia;
		}
		public function get precedencia():String
		{
			return this._precedencia==""?"NULL":this._precedencia
		}
		public var cod:String;
		private var _vveiCodigo:String;
		public var vehiclePlate:String;
		public var desc:String;
		public var cor:String;
		public var seq:String;
		private var _precedencia:String;
		private var _vveiEvcaCodigo:String;
		private var _vveiMotoPfisPessOrasCodigo:String;
		private var _vveiUsuarioAdicionou:String;
		private var _vveiUsuarioAlterou:String;
		public var selected:Boolean=false;
	}
}