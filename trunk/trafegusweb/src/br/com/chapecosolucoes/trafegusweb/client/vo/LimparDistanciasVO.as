package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.enum.LimparDistanciasEnum;

	[Bindable]
	public class LimparDistanciasVO
	{
		public function LimparDistanciasVO()
		{
		}
		public var veiculos:LimparDistanciasEnum;
		public var referencias:LimparDistanciasEnum;
		public var veiculoEReferencia:LimparDistanciasEnum;
	}
}