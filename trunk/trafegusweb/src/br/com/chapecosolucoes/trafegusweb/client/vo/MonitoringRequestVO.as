package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class MonitoringRequestVO
	{
		public function MonitoringRequestVO()
		{
		}
		public function setMonitoringRequestVO(obj:Object):void
		{
			this.codigoTipoViagem = obj.ttra_codigo.toString();
			this.descricaoTipoViagem = obj.ttra_descricao.toString();
			this.codigoViagemPai = obj.viag_codigo_pai.toString();
			this.codigoTransportador = obj.codigo_transportador.toString();
			this.nomeTransportador = obj.nome_transportador.toString();
			this.codigoEmbarcador = obj.codigo_embarcador.toString();
			this.nomeEmbarcador = obj.nome_embarcador.toString();
			this.nomeEmbarcador = obj.embarcador.toString();
			this.numeroViagem = obj.viag_codigo.toString();
			this.operacao = obj.viag_tope_codigo.toString();
			this.codigoVeiculo = obj.codigo_veiculo.toString();
			this.placaVeiculo = obj.placa_veiculo.toString();
			this.terminal = obj.term_numero_terminal.toString();
			this.dataCadastro = obj.viag_data_cadastro.toString();
			this.codigoOrigem = obj.codigo_origem.toString();
			this.descricaoOrigem = obj.descricao_origem.toString();
			this.codigoDestino = obj.codigo_destino.toString();
			this.descricaoDestino = obj.descricao_destino.toString();
			this.prevInicio = obj.viag_previsao_inicio.toString();
			this.prevFim = obj.viag_previsao_fim.toString();
			this.codigoRota = obj.rota_codigo.toString();
			this.descricaoRota = obj.rota_descricao.toString();
		}
		public var codigoTipoViagem:String = "";
		public var descricaoTipoViagem:String = "";
		public var codigoViagemPai:String = "";
		public var previsaoInicioViagemPai:String = "";
		public var previsaoFimViagemPai:String = "";
		public var codigoTransportador:String = "";
		public var nomeTransportador:String = "";
		public var codigoEmbarcador:String = "";
		public var nomeEmbarcador:String = "";
		public var codigoVeiculo:String = "";
		public var placaVeiculo:String = "";
		public var codigoMotorista:String = "";
		public var nomeMotorista:String = "";
		public var codigoPGR:String = "";
		public var descricaoPGR:String = "";
		public var codigoRota:String = "";
		public var descricaoRota:String = "";
		public var codigoOrigem:String = "";
		public var descricaoOrigem:String = "";
		public var codigoDestino:String = "";
		public var descricaoDestino:String = "";
		public var prevInicio:String = "";
		public var prevFim:String = "";
		public var dataCadastro:String = "";
		public var operacao:String = "";
		public var numeroViagem:String = "";
		public var terminal:String = "";
	}
}