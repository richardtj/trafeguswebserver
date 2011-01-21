package br.com.chapecosolucoes.trafegusweb.client.model
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.LimparDistanciasVO;

	[Bindable]
	public class LimparDistanciasModel
	{
		public function LimparDistanciasModel()
		{
			limparDistanciasVO = new LimparDistanciasVO();
		}
		public var limparDistanciasVO:LimparDistanciasVO;
	}
}