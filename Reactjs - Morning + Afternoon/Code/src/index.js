import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';


import { createStore } from 'redux'
import { Provider } from 'react-redux'
import combineReducers from './redux/reducers/index'
import 'bootstrap/dist/css/bootstrap.min.css';

const store = createStore(
  combineReducers ,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
)

ReactDOM.render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById('root')
);

reportWebVitals();