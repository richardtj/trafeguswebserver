package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import org.osmf.layout.AbsoluteLayoutFacet;
	[Bindable]
	public class DadosEmbarcadorVO extends EmbarcadorVO
	{
		public function DadosEmbarcadorVO()
		{
			super();
		}
		public function setDadosEmbarcadorVO(obj:Object):void
		{
			this.codigoEmbarcador = obj.emba_pjur_pess_oras_codigo.toString();
			this.razaoSocial = obj.pjur_razao_social.toString();
			super.setEmbarcadorVO(obj);
		}
		public var codigoEmbarcador:String;
		public var razaoSocial:String;
	}
}