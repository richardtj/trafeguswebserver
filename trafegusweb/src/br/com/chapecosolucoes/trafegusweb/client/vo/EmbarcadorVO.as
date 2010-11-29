package br.com.chapecosolucoes.trafegusweb.client.vo
{
	public class EmbarcadorVO
	{
		public function EmbarcadorVO(obj:Object)
		{
			this.codigo = obj.oras_codigo.toString();
			this.dataCadastro = obj.oras_data_cadastro.toString();
			this.cnpj = obj.pjur_cnpj.toString();
			this.nome = obj.pess_nome.toString();
			this.ie = obj.pjur_inscricao_estadual.toString();
			this.site = obj.pjur_site.toString();
		}
		public var codigo:String;
		public var dataCadastro:String;
		public var nome:String;
		public var cnpj:String;
		public var ie:String;
		public var site:String;		
	}
}