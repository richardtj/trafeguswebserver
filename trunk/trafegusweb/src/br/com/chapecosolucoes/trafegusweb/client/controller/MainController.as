package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.MainView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import com.google.maps.LatLng;

	public class MainController
	{
		public function MainController()
		{
		}
		public var view:MainView;
		public function addPoint():void
		{
			var posicaoVeiculoVO:PosicaoVeiculoVO = new PosicaoVeiculoVO();
			posicaoVeiculoVO.ignition = 0;
			posicaoVeiculoVO.vehiclePlate = "AAA1234";
			posicaoVeiculoVO.gpsDescSis = "teste xyz";
			posicaoVeiculoVO.latLong = new LatLng(-15.779413016690475, -47.929744720458984);
			
			MainModel.getInstance().posicaoVeiculoVO = posicaoVeiculoVO;
		}
	}
}