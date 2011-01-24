package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class TipoParadaVO
	{
		public function TipoParadaVO()
		{
		}
		public function setTipoParadaVO(obj:Object):void
		{
			this.codigo = obj.tpar_codigo.toString();
			this.descricao = obj.tpar_descricao.toString();
		}
		public var codigo:String;
		public var descricao:String;
	}
}