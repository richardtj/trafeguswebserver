package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class ParadaVO
	{
		public function ParadaVO()
		{
		}
		public function setParadaVO(obj:Object):void
		{
			this.tipoParadaVO.setTipoParadaVO(obj);
			this.localVO.setLocalVO(obj);
		}
		public var tipoParadaVO:TipoParadaVO = new TipoParadaVO();
		public var localVO:LocalVO = new LocalVO();
	}
}