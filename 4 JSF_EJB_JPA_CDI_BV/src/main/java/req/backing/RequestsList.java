package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    private HtmlDataTable requestsDataTable;

    @Size(min = 3, max = 60, message = "{request.size}")
    private String newRequest;

    @Inject
    private RequestFacadeLocal requestFacade;

    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    public String getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    public RequestsList() {
        //requestFacade = new ???
    }

    public List<Request> getAllRequests() {
        return requestFacade.findAll();
    }

    public String addRequest() {
        LocalDate now = LocalDate.now();
        Request request = new Request(newRequest, now);
        requestFacade.create(request);
        setNewRequest("");
        return null;
    }

    public String deleteRequest() {
        Request request = (Request) getRequestsDataTable().getRowData();
        requestFacade.remove(request);
        return null;
    }
}
