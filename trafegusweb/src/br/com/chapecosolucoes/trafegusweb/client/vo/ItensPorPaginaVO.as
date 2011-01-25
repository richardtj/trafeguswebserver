package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class ItensPorPaginaVO
	{
		public function ItensPorPaginaVO()
		{
		}
		public function setItensPorPaginaVO(obj:Object):void
		{
			switch(obj.sreg_chave.toString())
			{
				case "itensPorPagina":
					this.itensPorPagina = obj.sreg_valor.toString();
					break;
				default:
					break;
			}
		}
		public var itensPorPagina:int = 20;
	}
}