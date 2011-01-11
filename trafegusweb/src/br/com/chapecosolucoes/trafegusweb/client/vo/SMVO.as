package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class SMVO
	{
		public function SMVO()
		{
		}
		public function setSMVO(obj:Object):void
		{
			this.numeroViagem = obj.viag_codigo.toString();
			this.operacao = obj.viag_tope_codigo.toString();
			this.placa = obj.veic_placa.toString();
			this.terminal = obj.term_numero_terminal.toString();
			this.dataCadastro = obj.viag_data_cadastro.toString();
			this.transportador = obj.transportador.toString();
			this.embarcador = obj.embarcador.toString();
			this.origem = obj.origem.toString();
			this.destino = obj.destino.toString();
			this.prevInicio = obj.viag_previsao_inicio.toString();
			this.prevFim = obj.viag_previsao_fim.toString();
		}
		public var numeroViagem:String;
		public var operacao:String;
		public var placa:String;
		public var terminal:String;
		public var dataCadastro:String;
		public var transportador:String;
		public var embarcador:String;
		public var origem:String;
		public var destino:String;
		public var prevInicio:String;
		public var prevFim:String;
	}
}