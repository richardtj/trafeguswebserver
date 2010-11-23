package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class DadosVeiculoVO
	{
		public function DadosVeiculoVO()
		{
		}
		public function setDadosVeiculoVO(obj:Object):void
		{
			this.dataCadastro = obj.oras_data_cadastro.toString();
			this.placa = obj.veic_placa.toString();
			this.anoFabricacao = obj.veic_ano_fabricacao.toString();
			this.anoModelo = obj.veic_ano_modelo.toString();
			this.renavam = obj.veic_renavam.toString();
			this.chassi = obj.veic_chassi.toString();
			this.cor = obj.veic_cor.toString();
			this.descricao = obj.tvei_descricao.toString();
			this.usuario = obj.veic_usuario_alterou.toString();
		}
		public var dataCadastro:String;
		public var placa:String;
		public var anoFabricacao:String;
		public var anoModelo:String;
		public var renavam:String;
		public var chassi:String;
		public var cor:String;
		public var descricao:String;
		public var usuario:String;
	}
}