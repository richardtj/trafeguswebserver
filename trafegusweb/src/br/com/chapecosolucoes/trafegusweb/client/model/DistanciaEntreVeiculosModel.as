package br.com.chapecosolucoes.trafegusweb.client.model
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;

	[Bindable]
	public class DistanciaEntreVeiculosModel
	{
		public function DistanciaEntreVeiculosModel()
		{
		}
		public var veiculoDe:PosicaoVeiculoVO = new PosicaoVeiculoVO();
		public var veiculoAte:PosicaoVeiculoVO = new PosicaoVeiculoVO();
	}
}