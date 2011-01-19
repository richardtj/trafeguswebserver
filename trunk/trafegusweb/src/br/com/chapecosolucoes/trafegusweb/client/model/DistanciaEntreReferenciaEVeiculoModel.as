package br.com.chapecosolucoes.trafegusweb.client.model
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;

	[Bindable]
	public class DistanciaEntreReferenciaEVeiculoModel
	{
		public function DistanciaEntreReferenciaEVeiculoModel()
		{
		}
		public var posicaoVeiculoVO:PosicaoVeiculoVO = new PosicaoVeiculoVO();
		public var referenciaVO:ReferenciaVO = new ReferenciaVO();
	}
}