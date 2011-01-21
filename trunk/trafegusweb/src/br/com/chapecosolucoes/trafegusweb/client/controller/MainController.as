package br.com.chapecosolucoes.trafegusweb.client.controller
{
    import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
    import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
    import br.com.chapecosolucoes.trafegusweb.client.enum.LimparDistanciasEnum;
    import br.com.chapecosolucoes.trafegusweb.client.enum.VehicleEnum;
    import br.com.chapecosolucoes.trafegusweb.client.events.CloseAppEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.DetailsEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreReferenciaEVeiculoSelecionadoEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreReferenciasSelecionadaEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreVeiculosSelecionadaEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.LimparDistanciasEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciasRecebidasEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesHistoricEvent;
    import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
    import br.com.chapecosolucoes.trafegusweb.client.model.UsuarioLogado;
    import br.com.chapecosolucoes.trafegusweb.client.view.ClassesReferenciaView;
    import br.com.chapecosolucoes.trafegusweb.client.view.ConfiguracaoGridsView;
    import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaDeAteReferenciaEVeiculoView;
    import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaDeAteReferenciasView;
    import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaDeAteVeiculosView;
    import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciaEVeiculoView;
    import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciasView;
    import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
    import br.com.chapecosolucoes.trafegusweb.client.view.LimparDistanciasView;
    import br.com.chapecosolucoes.trafegusweb.client.view.MainView2;
    import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciaEVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciasVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVeiculosVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.MonitoringRequestVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
    import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
    
    import com.google.maps.LatLng;
    
    import flash.display.DisplayObject;
    import flash.display.Sprite;
    import flash.utils.getQualifiedClassName;
    
    import mx.controls.Alert;
    import mx.core.FlexGlobals;
    import mx.core.IFlexDisplayObject;
    import mx.events.CloseEvent;
    import mx.events.MenuEvent;
    import mx.managers.PopUpManager;
    import mx.managers.PopUpManagerChildList;
    import mx.managers.SystemManager;
    import mx.rpc.events.ResultEvent;
    import mx.utils.ObjectUtil;

    public class MainController
    {
        public function MainController()
        {
        }

        public var view:MainView2;

        public function vehiclesReceivedEventHandler(event:VehiclesEvent):void
        {
            this.view.map.posicaoVeiculosArray(MainModel.getInstance().posVeiculosArray);
        }

        public function vehicleSelectedEventHandler(event:VehiclesEvent):void
        {
            this.view.map.posicaoVeiculoVO();
            this.view.details.posicaoVeiculoVO();
			this.view.detalhes.status = ObjectUtil.toString(event.placa);
            if (event.enum == VehicleEnum.LIST)
            {
                this.view.details.selectedIndex = event.index;
            }
            else if (event.enum == VehicleEnum.DETAILS)
            {
                this.view.vehiclesView.selectedIndex = event.index;
            }
        }

        public function routeReceivedEventHandler(event:VehiclesHistoricEvent):void
        {
            this.view.map.rotaVeiculo(MainModel.getInstance().historicoPosicoesVeiculosArray);
        }

        public function closeApp(event:CloseEvent):void
        {
            if (event.detail == Alert.OK)
            {
				this.closeAllPopups();
                UsuarioLogado.getInstance().cleanUp();
                MainModel.getInstance().cleanUp();
                var closeEvent:CloseAppEvent = new CloseAppEvent(CloseAppEvent.CLOSE_APP_EVENT);
                this.view.dispatchEvent(closeEvent);
            }
        }
		private function closeAllPopups():void
		{
			var length:int = MainModel.getInstance().popupsArray.length;
			for(var i:int=0;i < length;i++)
			{
				MyPopUpManager.removePopUp(IFlexDisplayObject(MainModel.getInstance().popupsArray.removeItemAt(0)));
			}
		}

        public function closeEventHandler(event:CloseEvent):void
        {
            if (event.target.id.toString() == "veiculos")
            {
                this.view.veiculos.visible = false;
                this.view.myMenuBar.menuBarItems[1].data.menuitem[0].@toggled = "false";

                this.view.oh.unregisterComponent(this.view.veiculos);
            }
            if (event.target.id.toString() == "mapa")
            {
                this.view.mapa.visible = false;
                this.view.myMenuBar.menuBarItems[1].data.menuitem[2].@toggled = "false";
                this.view.oh.unregisterComponent(this.view.mapa);
            }
            if (event.target.id.toString() == "detalhes")
            {
                this.view.detalhes.visible = false;
                this.view.myMenuBar.menuBarItems[1].data.menuitem[1].@toggled = "false";
                this.view.oh.unregisterComponent(this.view.detalhes);
            }
            this.view.oh.selectionManager.clearSelection();
        }

        public function itemClickedHandler(event:MenuEvent):void
        {
            if (event.label == "Veiculos")
            {
                this.view.veiculos.visible = !this.view.veiculos.visible;
                if (this.view.veiculos.visible)
                {
                    this.view.oh.registerComponent(this.view.veiculos, this.view.veiculos);
                }
                else
                {
                    this.view.oh.unregisterComponent(this.view.veiculos);
                }
            }
            if (event.label == "Mapa")
            {
                this.view.mapa.visible = !this.view.mapa.visible;
                if (this.view.mapa.visible)
                {
                    this.view.oh.registerComponent(this.view.mapa, this.view.mapa);
                }
                else
                {
                    this.view.oh.unregisterComponent(this.view.mapa);
                }
            }
            if (event.label == "Detalhes")
            {
                this.view.detalhes.visible = !this.view.detalhes.visible;
                if (this.view.mapa.visible)
                {
                    this.view.oh.registerComponent(this.view.detalhes, this.view.detalhes);
                }
                else
                {
                    this.view.oh.unregisterComponent(this.view.detalhes);
                }
            }
            if (event.label == "Salvar")
            {
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosX = this.view.veiculos.x;
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosY = this.view.veiculos.y;
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosPercentWidth = (100 * this.view.veiculos.width) / FlexGlobals.topLevelApplication.width;
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosPercentHeight = (100 * this.view.veiculos.height) / FlexGlobals.topLevelApplication.height;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGoogleX = this.view.mapa.x;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGoogleY = this.view.mapa.y;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGooglePercentWidth = (100 * this.view.mapa.width) / FlexGlobals.topLevelApplication.width;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGooglePercentHeight = (100 * this.view.mapa.height) / FlexGlobals.topLevelApplication.width;
                ;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalheX = this.view.detalhes.x;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalheY = this.view.detalhes.y;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalhePercentWidth = (100 * this.view.detalhes.width) / FlexGlobals.topLevelApplication.width;
                ;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalhePercentHeight = (100 * this.view.detalhes.height) / FlexGlobals.topLevelApplication.width;

                TrafegusWS.getIntance().salvarPosicaoTelas(salvarPosicaoTelasResultHandler);
            }
            if (event.label == "Sair")
            {
                MessageBox.atencao("Deseja sair da aplicação", "", Alert.OK | Alert.CANCEL, this.view, this.closeApp);
            }
            if (event.label == "Agendamento")
            {
				MainModel.getInstance().smVO = new MonitoringRequestVO();
                var monitoringRequest:MonitoringRequestWiew = new MonitoringRequestWiew();
                MyPopUpManager.addPopUp(monitoringRequest, DisplayObject(FlexGlobals.topLevelApplication));
                MyPopUpManager.centerPopUp(monitoringRequest);
            }
            if (event.label == "Referências")
            {
                var referencias:ClassesReferenciaView = new ClassesReferenciaView();
                referencias.addEventListener(ReferenciasRecebidasEvent.REFERENCIAS_RECEBIDAS_EVENT, referenciasRecebidasResultHandler);
                MyPopUpManager.addPopUp(referencias, DisplayObject(FlexGlobals.topLevelApplication));
                MyPopUpManager.centerPopUp(referencias);
            }
			if(event.label == "Entre veículos")
			{
				var distanciaDeAteVeiculosView:DistanciaDeAteVeiculosView = new DistanciaDeAteVeiculosView();
				distanciaDeAteVeiculosView.addEventListener(DistanciaEntreVeiculosSelecionadaEvent.DISTANCIA_ENTRE_VEICULOS_ADICIONADA_EVENT,distanciaEntreVeiculosAdicionadaEventHandler);
				distanciaDeAteVeiculosView.addEventListener(DistanciaEntreVeiculosSelecionadaEvent.DISTANCIA_ENTRE_VEICULOS_SELECIONADA_EVENT,distanciaEntreVeiculosSelecionadaEventHandler);
				distanciaDeAteVeiculosView.addEventListener(LimparDistanciasEvent.LIMPAR_DISTANCIAS_EVENT,limparDistanciaEntreVeiculosEventHandler);
				MyPopUpManager.addPopUp(distanciaDeAteVeiculosView,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(distanciaDeAteVeiculosView);
			}
			if(event.label == "Entre referências")
			{
				var distanciaDeAteReferenciasView:DistanciaDeAteReferenciasView = new DistanciaDeAteReferenciasView();
				distanciaDeAteReferenciasView.addEventListener(DistanciaEntreReferenciasSelecionadaEvent.DISTANCIA_ENTRE_REFERENCIAS_ADICIONADA_EVENT,distanciaEntreReferenciasAdicionadaEventHandler);
				distanciaDeAteReferenciasView.addEventListener(DistanciaEntreReferenciasSelecionadaEvent.DISTANCIA_ENTRE_REFERENCIAS_SELECIONADA_EVENT,distanciaEntreReferenciasSelecionadaEventHandler);
				distanciaDeAteReferenciasView.addEventListener(LimparDistanciasEvent.LIMPAR_DISTANCIAS_EVENT,limparDistanciasEntreReferenciasEventHandler);
				MyPopUpManager.addPopUp(distanciaDeAteReferenciasView,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(distanciaDeAteReferenciasView);
			}
			if(event.label == "Entre veículo e referência")
			{
				var distanciaDeAteReferenciaEVeiculoView:DistanciaDeAteReferenciaEVeiculoView = new DistanciaDeAteReferenciaEVeiculoView();
				distanciaDeAteReferenciaEVeiculoView.addEventListener(DistanciaEntreReferenciaEVeiculoSelecionadoEvent.DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_ADICIONADA_EVENT,distanciaEntreReferenciaEVeiculoAdicionadaEventHandler);
				distanciaDeAteReferenciaEVeiculoView.addEventListener(DistanciaEntreReferenciaEVeiculoSelecionadoEvent.DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_SELECIONADA_EVENT,distanciaEntreReferenciaEVeiculoSelecionadaEventHandler);
				distanciaDeAteReferenciaEVeiculoView.addEventListener(LimparDistanciasEvent.LIMPAR_DISTANCIAS_EVENT,limparDistanciasEntreReferenciaEVeiculoEventHandler);
				MyPopUpManager.addPopUp(distanciaDeAteReferenciaEVeiculoView,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(distanciaDeAteReferenciaEVeiculoView);
			}
			if(event.label == "Grids")
			{
				var configuracaoGris:ConfiguracaoGridsView = new ConfiguracaoGridsView();
				MyPopUpManager.addPopUp(configuracaoGris,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(configuracaoGris);
			}
        }
		private function limparDistanciaEntreVeiculosEventHandler(event:LimparDistanciasEvent):void
		{
			var length:int = event.limparDistanciasArray.length;
			for (var i:int = 0;i < length;i++)
			{
				this.view.map.removerDistanciaEntreVeiculos(DistanciaDeAteVeiculosVO(MainModel.getInstance().distanciaEntreVeiculos.removeItemAt(MainModel.getInstance().distanciaEntreVeiculos.getItemIndex(DistanciaDeAteVeiculosVO(event.limparDistanciasArray.getItemAt(i))))));
			}
		}
		private function limparDistanciasEntreReferenciasEventHandler(event:LimparDistanciasEvent):void
		{
			var length:int = event.limparDistanciasArray.length;
			for (var i:int = 0;i < length;i++)
			{
				this.view.map.removerDistanciaEntreReferencias(DistanciaDeAteReferenciasVO(MainModel.getInstance().distanciaEntreReferencias.removeItemAt(MainModel.getInstance().distanciaEntreReferencias.getItemIndex(DistanciaDeAteReferenciasVO(event.limparDistanciasArray.getItemAt(i))))));
			}	
		}
		private function limparDistanciasEntreReferenciaEVeiculoEventHandler(event:LimparDistanciasEvent):void
		{
			var length:int = event.limparDistanciasArray.length;
			for (var i:int = 0;i < length;i++)
			{
				this.view.map.removerDistanciaEntreReferenciaEVeiculo(DistanciaDeAteReferenciaEVeiculoVO(MainModel.getInstance().distanciaEntreReferenciaEVeiculo.removeItemAt(MainModel.getInstance().distanciaEntreReferenciaEVeiculo.getItemIndex(DistanciaDeAteReferenciaEVeiculoVO(event.limparDistanciasArray.getItemAt(i))))));
			}	
		}
		
		private function distanciaEntreReferenciasSelecionadaEventHandler(event:DistanciaEntreReferenciasSelecionadaEvent):void
		{
			this.view.map.focarDistancia(event.distanciaEntreReferenciasVO);
		}
		private function distanciaEntreReferenciasAdicionadaEventHandler(event:DistanciaEntreReferenciasSelecionadaEvent):void
		{
			this.view.map.carregarReferencia(ReferenciaVO(event.distanciaEntreReferenciasVO.de));
			this.view.map.carregarReferencia(ReferenciaVO(event.distanciaEntreReferenciasVO.ate));
			
			this.view.map.distanciaEntreReferencias(event.distanciaEntreReferenciasVO);
		}
		
		private function distanciaEntreVeiculosAdicionadaEventHandler(event:DistanciaEntreVeiculosSelecionadaEvent):void
		{
			this.view.map.distanciaEntreVeiculos(event.distanciaEntreVeiculosVO);
		}
		private function distanciaEntreVeiculosSelecionadaEventHandler(event:DistanciaEntreVeiculosSelecionadaEvent):void
		{
			this.view.map.focarDistancia(event.distanciaEntreVeiculosVO);
		}
		private function distanciaEntreReferenciaEVeiculoSelecionadaEventHandler(event:DistanciaEntreReferenciaEVeiculoSelecionadoEvent):void
		{
			this.view.map.focarDistancia(event.distanciaEntreReferenciaEVeiculoVO);
		}
		private function distanciaEntreReferenciaEVeiculoAdicionadaEventHandler(event:DistanciaEntreReferenciaEVeiculoSelecionadoEvent):void
		{
			if(event.distanciaEntreReferenciaEVeiculoVO.de is ReferenciaVO)
			{
				this.view.map.carregarReferencia(ReferenciaVO(event.distanciaEntreReferenciaEVeiculoVO.de));
			}
			if(event.distanciaEntreReferenciaEVeiculoVO.ate is ReferenciaVO)
			{
				this.view.map.carregarReferencia(ReferenciaVO(event.distanciaEntreReferenciaEVeiculoVO.ate));
			}
			this.view.map.distanciaEntreReferenciaEVeiculo(event.distanciaEntreReferenciaEVeiculoVO);
		}

        private function referenciasRecebidasResultHandler(event:ReferenciasRecebidasEvent):void
        {
            this.view.map.carregarReferencias();
        }

        public function pageChangedEventHandler(event:PaginableEvent):void
        {
            if (event.currentTarget == this.view.vehiclesView)
            {
                this.view.details.paginaAtual = event.paginaAtual;
            }
            else
            {
                this.view.vehiclesView.paginaAtual = event.paginaAtual;
            }
        }

        private function salvarPosicaoTelasResultHandler(event:ResultEvent):void
        {
            MessageBox.informacao("As posições atuais, foram salvas");
        }
    }
}