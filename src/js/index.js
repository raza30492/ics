import '../scss/index.scss';

import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { Router,hashHistory} from "react-router";

import routes from "./routes";
import store from "./store";

(function () {
  // const baseUrl = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port: '');
  // window.baseUrl = baseUrl + '/e-kanban';
  // window.serviceHost = baseUrl + "/e-kanban/api";

  window.baseUrl = 'http://localhost:8000';
  window.serviceHost = "http://localhost:8000/api";

})();

let element = document.getElementById('content');
ReactDOM.render((
  <div>
    <Provider store={store} >
        <Router routes={routes} history={hashHistory} />
    </Provider>
  </div>
), element);

document.body.classList.remove('loading');
