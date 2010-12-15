package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.enum.SexoEnum;
	import br.com.chapecosolucoes.trafegusweb.client.enum.SimNaoEnum;

	[Bindable]
	public class DadosMotoristaVO extends MotoristaVO
	{
		public function DadosMotoristaVO()
		{
		}
		public function setDadosMotoristaVO(obj:Object):void
		{
			this.codigo = obj.oras_codigo.toString();
			this.dataCadastro = obj.oras_data_cadastro.toString();
			this.motoristaPrincipal = obj.pess_nome.toString();
			this.rg = obj.pfis_rg.toString();
			this.cpfMotoristaPrincipal = obj.pfis_cpf.toString();
			if(obj.pfis_sexo.toString().search("F")>=0)
			{
				this.sexo = SexoEnum.FEMININO.toString();
			}
			else
			{
				this.sexo = SexoEnum.MASCULINO.toString();
			}
			this.codigoCNH = obj.moto_epmo_codigo.toString();
			this.numeroCNH = obj.moto_numero_cnh.toString();
			this.categoriaCNH = obj.moto_categoria_cnh.toString();
			this.validadeCNH = obj.moto_validade_cnh.toString();
			if(obj.moto_treinado.toString().search("S")>=0)
			{
				this.treinado = SimNaoEnum.SIM.toString();
			}
			else
			{
				this.treinado = SimNaoEnum.NAO.toString();
			}
			this.ultimoTreinamento = obj.moto_ultimo_treinamento.toString();
			this.validadePesquisa = obj.moto_validade_pesquisa.toString();
		}
		public var dataCadastro:String;
		public var rg:String;
		public var cpfMotoristaPrincipal:String;
		public var sexo:String;
		public var codigoCNH:String;
		public var numeroCNH:String;
		public var categoriaCNH:String;
		public var validadeCNH:String;
		public var treinado:String;
		public var ultimoTreinamento:String;
		public var validadePesquisa:String;
	}
}