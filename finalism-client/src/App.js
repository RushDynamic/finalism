import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Header from "./components/header/Header";
import Submit from "./components/submit/Submit";
import Redirect from "./components/Redirect";
import NotFound from "./components/error/NotFound";
import 'semantic-ui-css/semantic.min.css'
import './styles/app.scss';


function App() {
  return (
    <div>
      <div className="main-container">
        <Router>
          <Switch>
            <Route exact path='/'>
              <Header />
              <Submit />
            </Route>
            <Route path='/404'>
              <Header />
              <NotFound />
            </Route>
            <Route path='/:url'>
              <Header />
              <Redirect />
            </Route>
          </Switch>
        </Router>

      </div>
    </div>
  );
}

export default App;
