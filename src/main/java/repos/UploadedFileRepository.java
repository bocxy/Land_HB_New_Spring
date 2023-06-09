package repos;

import models.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
    UploadedFile findById(@Param("id") String id);

    UploadedFile findByFilename(@Param("Filename") String Filename);


    String findFilePathByFilename(String filename);

    List<UploadedFile> findAllByLandname(String land_name);
}