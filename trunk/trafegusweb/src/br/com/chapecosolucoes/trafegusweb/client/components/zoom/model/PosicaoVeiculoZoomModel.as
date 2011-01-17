package br.com.chapecosolucoes.trafegusweb.client.components.zoom.model
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;

	[Bindable]
	public class PosicaoVeiculoZoomModel
	{
		public function PosicaoVeiculoZoomModel()
		{
		}
		public var excluirVeiculoListaZoom:String = "";
		public var posicaoVeiculoVOExcluido:PosicaoVeiculoVO = new PosicaoVeiculoVO();
	}
}