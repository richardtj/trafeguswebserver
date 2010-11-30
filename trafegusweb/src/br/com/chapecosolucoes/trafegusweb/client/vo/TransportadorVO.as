package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class TransportadorVO
	{
		public function TransportadorVO()
		{
		}
		public function setTransportadorVO(obj:Object):void{
			this.codigo = obj.oras_codigo.toString();
			this.dataCadastro = obj.oras_data_cadastro.toString();
			this.nome = obj.pess_nome.toString();
			this.cnpj = obj.pjur_cnpj.toString();
			this.ie = obj.pjur_inscricao_estadual.toString();
			this.site = obj.pjur_site.toString();
			this.rg = obj.pfis_rg.toString();
			this.cpf = obj.pfis_cpf.toString();
		}
		public var codigo:String;
		public var dataCadastro:String;
		public var nome:String;
		public var cnpj:String;
		public var ie:String;
		public var site:String;
		public var rg:String;
		public var cpf:String;
	}
}