package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class PesquisaMotoristaVO
	{
		public function PesquisaMotoristaVO()
		{
		}
		public function setPesquisaMotoristaVO(obj:Object):void
		{
			this.codigo = obj.hpmo_epmo_codigo.toString();
			this.mensagem = obj.hpmo_mensagem.toString();
			this.dataValidade = obj.hpmo_prazo_validade.toString();
		}
		public var codigo:String;
		public var mensagem:String;
		public var dataValidade:String;
	}
}