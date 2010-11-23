package br.com.chapecosolucoes.trafegusweb.client.vo
{
	public class VeiculoViagemVO extends PosicaoVeiculoVO
	{
		public function VeiculoViagemVO(obj:Object=null)
		{
			super(null);
			super.vehiclePlate = obj.placa.toString();
			super.gpsDescSis = obj.posicao;
			super.ignition = int(obj.ignicao);
			super.versaoTecnologia = obj.versaotecnologia.toString();
			super.numeroTerminal = obj.numeroterminal.toString();
			super.tipoVeiculo = obj.tipoveiculo.toString();
			super.statusViagem = obj.statusviagem.toString();
			super.statusAtraso = obj.statusatraso.toString();
			super.embarcador = obj.embarcador.toString();
			this.dataInicio = obj.viag_data_inicio.toString();
			this.dataFim = obj.viag_data_fim.toString();
			this.previsaoInicio = obj.viag_previsao_inicio.toString();
			this.previsaoFim = obj.viag_previsao_fim.toString();
			this.origem = obj.origem.toString();
			this.destino = obj.destino.toString();
			this.proximoDestino = obj.proximodestino.toString();
		}
		public var dataInicio:String;
		public var dataFim:String;
		public var previsaoInicio:String;
		public var previsaoFim:String;
		public var origem:String;
		public var destino:String;
		public var proximoDestino:String;
	}
}