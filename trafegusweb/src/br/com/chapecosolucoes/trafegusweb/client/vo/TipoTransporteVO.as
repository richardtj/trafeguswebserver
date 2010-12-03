package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class TipoTransporteVO
	{
		public function TipoTransporteVO()
		{
		}
		public function setTipoTransporteVO(obj:Object):void
		{
			this.codigo = obj.ttra_codigo.toString();
			this.descricao = obj.ttra_descricao.toString();
		}
		public var codigo:String;
		public var descricao:String;
	}
}