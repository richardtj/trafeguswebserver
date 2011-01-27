package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
	
	import mx.utils.ObjectUtil;

	[Bindable]
	public class TerminalVO
	{
		public function TerminalVO()
		{
		}
		public function setTerminalVO(obj:Object):void
		{
			this.precedencia = obj.orte_sequencia.toString();
			this.codigo = obj.term_codigo.toString();
			this.numero = obj.term_numero_terminal.toString();
			this.ativo = obj.term_ativo.toString();
			this.ativoWS = obj.term_ativo_ws.toString();
			this.tempoSatelital = obj.term_tempo_satelital.toString();
			this.tempoGPRS = obj.term_tempo_gprs.toString();
			this._vtecCodigo = obj.term_vtec_codigo.toString();
			this._vterUsuarioAdicionou = obj.term_usuario_adicionou.toString();
			this._vterUsuarioAlterou = obj.term_usuario_alterou.toString();
			this._vterDataCadastro = obj.term_data_cadastro.toString();
		}
		public function get vtecCodigo():String
		{
			return this._vtecCodigo==""?"nextval('s_vter_viagem_terminal')":this._vtecCodigo;
		}
		public function get vterDataCadastro():String
		{
			return this._vterDataCadastro==""?MyDateFormatter.getInstance().parse(new Date()):this._vterDataCadastro;
		}
		public function get vterUsuarioAdicionou():String
		{
			return this._vterUsuarioAdicionou==""?ObjectUtil.toString(MainModel.getInstance().codUsuario):this._vterUsuarioAdicionou;
		}
		public function get vterUsuarioAlterou():String
		{
			return ObjectUtil.toString(MainModel.getInstance().codUsuario);
		}
		public var precedencia:String;
		public var codigo:String;
		public var numero:String;
		public var descricao:String;
		public var tipoComunicacao:String;
		public var tecnologia:String;
		public var ativo:String;
		public var ativoWS:String;
		public var tempoSatelital:String;
		public var tempoGPRS:String;
		public var veiculo:String;
		private var _vtecCodigo:String;
		private var _vterUsuarioAdicionou:String;
		private var _vterUsuarioAlterou:String;
		private var _vterDataCadastro:String;
	}
}