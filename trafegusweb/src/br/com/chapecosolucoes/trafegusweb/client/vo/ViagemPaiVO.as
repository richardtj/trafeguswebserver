package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class ViagemPaiVO
	{
		public function ViagemPaiVO()
		{
		}
		public function setViagemPaiVO(obj:Object):void
		{
			this.codigo = obj.viag_codigo.toString();
			this.previsaoInicio = obj.viag_previsao_inicio.toString();
			this.previsaoFim = obj.viag_previsao_fim.toString();
		}
		public var codigo:String = "";
		public var previsaoInicio:String = "";
		public var previsaoFim:String = "";
	}
}