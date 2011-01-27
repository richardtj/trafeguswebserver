package br.com.chapecosolucoes.trafegusweb.client.vo
{
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
			this.vtecCodigo = obj.term_vtec_codigo.toString();
			this.vterUsuarioAdicionou = obj.term_usuario_adicionou.toString();
			this.vterUsuarioAlterou = obj.term_usuario_alterou.toString();
			this.vterDataCadastro = obj.term_data_cadastro.toString();
		}
		public function get vterCodigo():String
		{
			return this.codigo==""?"nextval('s_vter_viagem_terminal')":this.codigo;
		}
		public function set vterCodigo(vter_codigo:String):void
		{
			this.codigo = vter_codigo
		}
		public var precedencia:String;
		public var codigo:String;
		public var numero:String;
		public var descricao:String;
		public var tipoComunicacao:String;
		public var tecnologia:String;
		public var vtecCodigo:String;
		public var ativo:String;
		public var ativoWS:String;
		public var tempoSatelital:String;
		public var tempoGPRS:String;
		public var veiculo:String;
		public var vterUsuarioAdicionou:String;
		public var vterUsuarioAlterou:String;
		public var vterDataCadastro:String;
	}
}