package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.exception.MissingBlogException;
import com.argentstew.simulator.battle.web.file.FileAccessor;
import com.argentstew.simulator.battle.web.model.BlogDTO;
import com.argentstew.simulator.battle.web.model.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 1/2/2022
 *
 * @author argen
 */
@Service
public class ScheduledBlogService implements BlogService {

    private static final Object LOCK = new Object();

    private final FileAccessor fileAccessor;
    private final String blogDirectory;

    private List<BlogDTO> blogEntries;

    @Autowired
    public ScheduledBlogService(FileAccessor fileAccessor,
                                @Value("${argent.dev.blog.directory}") String blogDirectory) {
        this.fileAccessor = fileAccessor;
        this.blogDirectory = blogDirectory;
    }

    @Override
    public List<BlogDTO> getEntryCatalog() {
        if (blogEntries == null || blogEntries.isEmpty()) {
            reloadEntryCatalog();
        }

        return blogEntries;
    }

    @Override
    public BlogDTO getEntry(int entryNumber) {
        if (entryNumber > 0 && entryNumber <= blogEntries.size()) {
            return fileAccessor.getBlogEntry(blogDirectory, entryNumber);
        }

        throw new MissingBlogException(String.format("Entry %d does not exist!", entryNumber));
    }

    @Scheduled(cron = "0 0 0 * * *")
    @Override
    public void reloadEntryCatalog() {
        synchronized (LOCK) {
            blogEntries = fileAccessor.getAllBlogTitles(blogDirectory);
        }
    }

    @Override
    public ImageDTO getBlogImage(String image) {
        return fileAccessor.getImage(blogDirectory, String.format("images/%s", image));
    }
}
