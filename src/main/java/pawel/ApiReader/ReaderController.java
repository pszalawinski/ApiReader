package pawel.ApiReader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pawel.ApiReader.model.Owner;

import java.io.IOException;

@RestController
public class ReaderController {

    private ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/repositories/{owner}/{repository-name}")
    public Owner getInfoForOwnerRepository(@PathVariable("owner") String name, @PathVariable("repository-name") String repositoryName) throws IOException {
        System.out.println("getting repo info");
        return readerService.getRepositoryInfo(name,repositoryName);
    }
}
