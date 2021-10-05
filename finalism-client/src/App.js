import Header from "./components/header/Header";
import Submit from "./components/submit/Submit";
import 'semantic-ui-css/semantic.min.css'
import './styles/app.scss';

function App() {
  return (
    <div>
      <div className="main-container">
        <Header />
        <Submit />
      </div>
    </div>
  );
}

export default App;
