package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class PGRVO
	{
		public function PGRVO()
		{
		}
		public function setPGRVO(obj:Object):void
		{
			this.codigo = obj.pgpg_codigo.toString();
			this.descricao = obj.pgpg_descricao.toString();
			this.dataCadastro = obj.pgpg_data_cadastro.toString();
		}
		public var codigo:String;
		public var descricao:String;
		public var dataCadastro:String;
	}
}